'use strict';
module.exports = {
    up: async (queryInterface, sequelize) =>{
        await queryInterface.createTable('users', {
            id: {
                allowNull: false,
                autoIncrement: true,
                primaryKey: true,
                type: Sequelize.INTEGER
            },
            firstName: {
                type: Sequelize.STRING
            },
            lastName: {
                type: Sequelize.STRING
            },
            phone: {
                type: Sequelize.STRING
            },
            pin: {
                type:Sequelize.STRING
            },
            amount: {
                type: Sequelize.INTEGER
            },
            createdAt: {
                allowNull: false,
                type:Sequelize.DATE
            },
            updatedAt: {
                allowNull: false,
                type:Sequelize.DATE
            }
        });
    },
    down: async (queryInterface, Sequelize) => {
        await queryInterface.dropTable('users');
    }
};