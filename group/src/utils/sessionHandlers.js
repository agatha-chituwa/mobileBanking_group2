const UssdMenu = require("ussd-menu-builder");

let sessions = {};
let menu = new UssdMenu();
menu.sessionConfig({
    start: (sessionId, callback)=>{

        //session if it doesn't exist intialize 

        if(!(sessionId in sessions)) sessions[sessionId] = {};
        callback();
    },
    end: (sessionId, callback)=>{
        // omit session
        delete sessions[sessionId];
        callback();
    },
    set: (sessionId, key, value, callback) => {

        //keep the key value of session which is currently in operation
        sessions[sessionId][key] = value;
        callback();
    },
    // get back the key current in session
    get: (sessionId, key, callback)=>{
        let value = sessions[sessionId][key];
        callback(null, value);
    }
});

module.exports = menu;