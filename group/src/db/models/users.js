'use strict';
const {
    model
} = require('sequelize');
const { sequelize } = require('./migrations/models');
module.exports = (sequelize,DataTypes) => {
    class users extends model{
        static associate(models){

        }
    };
    users.init({
        firstName: DataTypes. STRING,
        lastName: DataTypes. STRING,
        phone: DataTypes. STRING,
        amount: DataTypes. INTEGER
    }, {
        sequelize,
        modelNmae: 'users',
    });
    return users;
};