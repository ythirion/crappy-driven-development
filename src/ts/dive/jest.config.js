module.exports = {
    roots: ['<rootDir>/tests'],
    collectCoverageFrom: ['<rootDir>/src/**/*.ts'],
    coverageDirectory: 'coverage',
    coverageProvider: 'v8',
    testEnvironment: 'node',
    transform: {
        '.+\\.ts$': 'ts-jest'
    }
}