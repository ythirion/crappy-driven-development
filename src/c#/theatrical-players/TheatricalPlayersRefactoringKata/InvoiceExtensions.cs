using System;
using System.Collections.Generic;
using static TheatricalPlayersRefactoringKata.TextFormatter;
using static TheatricalPlayersRefactoringKata.PricingCalculator;
using static TheatricalPlayersRefactoringKata.CreditsCalculator;

namespace TheatricalPlayersRefactoringKata;

public static class InvoiceExtensions
{
    public static string Print(
        this Invoice invoice,
        Dictionary<string, Play> plays)
        => Print(invoice, plays, FormatLineToText, FormatStatementToText);

    private static string Print(
        Invoice invoice,
        Dictionary<string, Play> plays,
        Func<string, int, int, string> lineFormatter,
        Func<string, Statement, string> statementFormatter)
        => invoice.Performances
            .Map(performance => CreateStatement(plays, performance, lineFormatter))
            .Reduce((context, line) => context.Append(line))
            ?.FormatFor(invoice.Customer, statementFormatter);

    private static Statement CreateStatement(
        IReadOnlyDictionary<string, Play> plays,
        Performance performance,
        Func<string, int, int, string> lineFormatter)
    {
        var performanceType = plays[performance.PlayId].Type;
        var amount =
            CalculatePriceFor(performanceType, performance.Audience)
                .Match(price => price, _ => throw new Exception("unknown type: " + performanceType));

        var credits = CalculateCreditsFor(performanceType, performance.Audience);

        return new Statement(
            lineFormatter(plays[performance.PlayId].Name, amount, performance.Audience),
            amount,
            credits);
    }
}