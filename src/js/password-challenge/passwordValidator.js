class PasswordValidator {
    static #passwordRegex = /(\d+)-(\d+) ([a-z]): ([a-z]+)/;

    static #isValid(passwordWithPolicy) {
        const nbOfAppearance = Array.from(passwordWithPolicy.password)
            .filter(letter => letter === passwordWithPolicy.letter)
            .length;
        return passwordWithPolicy.range.start <= nbOfAppearance
            && nbOfAppearance <= passwordWithPolicy.range.end;
    }

    static #toRange(matches) {
        const start = parseInt(matches[1]);
        const end = parseInt(matches[2]);
        return { start, end };
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
