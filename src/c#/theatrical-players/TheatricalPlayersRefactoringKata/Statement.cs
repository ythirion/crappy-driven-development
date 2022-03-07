using System;

namespace TheatricalPlayersRefactoringKata
{
    internal record Statement(string Text, int Amount, int Credits);

    internal static class Extensions
    {
        public static string FormatFor(
            this Statement statement,
            string customer,
            Func<string, Statement, string> formatter)
            => formatter(customer, statement);

        internal static Statement Append(
            this Statement statement,
            Statement append) =>
            statement with
            {
                Text = statement.Text + append.Text,
                Amount = statement.Amount + append.Amount,
                Credits = statement.Credits + append.Credits
            };
    }
}