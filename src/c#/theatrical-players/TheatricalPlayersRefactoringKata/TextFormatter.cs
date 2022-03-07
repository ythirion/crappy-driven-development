using System;
using System.Globalization;

namespace TheatricalPlayersRefactoringKata
{
    internal static class TextFormatter
    {
        private static readonly CultureInfo FormatProvider = new("en-US");

        internal static string FormatLineToText(string name, int amount, int audience)
            => string.Format(FormatProvider, "  {0}: {1:C} ({2} seats)\n", name, amount / 100, audience);

        internal static string FormatStatementToText(
            string customer,
            Statement statement) =>
            string.Format(FormatProvider,
                "Statement for {0}\n{1}Amount owed is {2:C}\nYou earned {3} credits\n",
                customer, statement.Text, Convert.ToDecimal(statement.Amount / 100), statement.Credits);
    }
}