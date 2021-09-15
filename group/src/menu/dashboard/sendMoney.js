const express = require("express");
const _ = require("lodash");
const sessionMenu = require("../../utils/sessionHandler");

const UserService = require("../../services/user.service");
let sessions = {};

module.exports = (menu) => {
  // Define menu states
  menu.state("dashboard.sendMoney", {
    run: async () => {
      const { val } = menu;
      menu.con(`Enter amount to send`);
    },
    // next object links to next state based on user input
    next: {
      "*\\d": "dashboard.sendMoney.receiver",
    },
    defaultNext: "invalidOption",
  });

  menu.state("dashboard.sendMoney.receiver", {
    run: async () => {
      const {
        val,
        args: { phoneNumber },
      } = menu;
      sessions["amount"] = val;
      const user = await UserService.findUserByPhone(phoneNumber);

      const enteredAmount = JSON.parse(val);
      console.log(enteredAmount, user.amount);
      if (val > user.amount) {
        menu.end("Sorry, you  insufficient funds!");
      } else {
        menu.con(`Enter phone number to send to`);
      }
    },
    // next object links to next state based on user input
    next: {
      "*\\d{10}": "dashboard.sendMoney.send",
    },
    defaultNext: "invalidOption",
  });

  menu.state("dashboard.sendMoney.send", {
    run: async () => {
      const {
        val,
        args: { phoneNumber },
      } = menu;

      const sender = await UserService.findUserByPhone(phoneNumber);
      const reciever = await UserService.findUserByPhone(val);
     
      if (reciever) {
        const amountToSend = sessions.amount;
        const balance = sender.amount - amountToSend;

        const senderPhone = phoneNumber;
        const receiverPhone = reciever.phone;
        await UserService.updateBalance(balance, senderPhone);
        const fullAmount  = parseFloat(amountToSend) + parseFloat(reciever.amount)
        await UserService.updateBalance(fullAmount, receiverPhone);
        menu.end(
          `You have successfully sent MWk ${amountToSend} to ${reciever.firstName} ${reciever.lastName} (${reciever.phone}). Your new balance is RWF ${balance}`
        );
      } else {
        menu.end("Invalid receipient");
      }
    },
    // next object links to next state based on user input
    next: {
      "*\\d{10}": "dashboard.sendMoney.send",
    },
  });

  menu.state("invalidOption", {
    run: () => {
      menu.end(`Incorrect input`);
    },
  });

  return menu;
};
