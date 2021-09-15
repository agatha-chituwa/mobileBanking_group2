const db = require ('../db/models');

// this part contains user access services form databse
class UserServices {
  static async findUserByPhone(phone) {
    try {
      const user = await db.users.findOne({ where: { phone } });
      if (!user) return null;
      return user;
    } catch (error) {
      return undefined;
    }
  }
static async updateBalance(amount, phone) {
    try {
      const user = await db.users.update(
       { amount},
        { where: { phone }}
      );
      return user;
    } catch (error) {
      return error;
    }
  }
 static async changePin(pin, phone) {
    try {
      const user = await db.users.update(
       { pin},
        { where: { phone }}
      );
      return user;
    } catch (error) {
      return error;
    }
  }

}
module.exports = UserServices;
