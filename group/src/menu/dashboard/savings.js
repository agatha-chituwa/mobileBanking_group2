const express = require("express");
const _ = require('lodash');

const UserService = require("../../services/user.service");

module.exports = menu => {
  let date_ob = new Date();
  // Define menu states
  menu.state("dashboard.savings", {
    run: async () => {
      // use menu.con() to send response without terminating session

      const { phoneNumber } = menu.args;

      const user = await UserService.findUserByPhone(phoneNumber);

      menu.con(`balance as on ${date_ob.getDate()}/${date_ob.getMonth()}/${date_ob.getFullYear()} for:${phoneNumber} is MWk:${user.amount}  \n 0. main menu`);
    },
    // next object links to next state based on user input
    next: {
      "0": "dashboard",
    },
  });

  menu.state("invalidOption", {
    run: () => {
      menu.end(`Invalid option`);
    },
  });

  return menu;
};

