const fs = require('fs');
const { PasswordValidator } = require('./passwordValidator');

describe('PasswordValidator', () => {
    const passwordEntries = fs.readFileSync('./passwords.txt', 'utf-8');

    it('should count 622 valid passwords', () => {
        expect(PasswordValidator.countValidPasswords(passwordEntries.split('\n')))
            .toBe(622);
    });
});
