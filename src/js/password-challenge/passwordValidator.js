class PasswordValidator {
    static #passwordRegex = /(\d+)-(\d+) ([a-z]): ([a-z]+)/;

    static #toRange(matches) {
        const start = parseInt(matches[1]);
        const end = parseInt(matches[2]);
        const length = end - start + 1;
        return Array.from(new Array(length), (_, i) => i + start);
    }

    static #isValid(passwordWithPolicy) {
        return passwordWithPolicy.range.includes(
            Array.from(passwordWithPolicy.password)
                .filter(letter => letter === passwordWithPolicy.letter)
                .length
        );
    }

    static #toPasswordWithPolicy(line) {
        const passwordWithPolicy = {};

        const matches = line.match(PasswordValidator.#passwordRegex);
        passwordWithPolicy.password = matches[4];
        passwordWithPolicy.range = PasswordValidator.#toRange(matches);
        passwordWithPolicy.letter = matches[3];

        return passwordWithPolicy;
    }

    static countValidPasswords(lines) {
        return lines.map(PasswordValidator.#toPasswordWithPolicy)
            .filter(PasswordValidator.#isValid)
            .length;
    }
}

module.exports = { PasswordValidator };
