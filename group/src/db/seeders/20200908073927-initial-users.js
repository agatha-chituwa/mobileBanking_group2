'use strict';

const { sequelize } = require("../../migrations/models");

module.exports = {
    up: async (queryInterface, Sequelize) => {
        await queryInterface.bulkInsert(
            "users",
            [
                {
                    firstName: "agatha",
                    lastName: "Chituwa",
                    phone: "+265992871482",
                    pin: 0042
                    ,
                    amount: 100000,
                    createdAt : "2021-09-28T10:55:51.603Z",
                    updateAt : "2021-09-28T10:55:51.603Z"
                },
                {
                    firstName: "Nick",
                    lastName: "Chikhwana",
                    phone: "+265888822521",
                    pin: 0232,
                    amount: 200000,
                    createdAt : "2021-09-28T10:55:51.603Z",
                    updateAt : "2021-09-28T10:55:51.603Z"   
                },
                {
                    firstName: "Wiliiam",
                    lastName: "chikaoneka",
                    phone: "+265888316204",
                    pin: 0111,
                    amount: 400000,
                    createdAt : "2021-09-28T10:55:51.603Z",
                    updateAt : "2021-09-28T10:55:51.603Z"
                },
            ],
            {}
        );
    },

    down: async (queryInterface, sequelize) => {
        await queryInterface.bulkDelete("users", null,{});
    },
};