using System;
using LanguageExt;

namespace TheatricalPlayersRefactoringKata
{
    internal static class PricingCalculator
    {
        public static Try<int> CalculatePriceFor(PlayType typeOfPerformance, int audience)
            => () => typeOfPerformance switch
            {
                PlayType.Tragedy => PriceForTragedy(audience),
                PlayType.Comedy => PriceForComedy(audience),
                _ => throw new ArgumentException("Unknown play type")
            };

        private static int PriceForTragedy(int audience)
            => audience > 30 ? 40_000 + 1_000 * (audience - 30) : 40_000;

        private static int PriceForComedy(int audience)
            => 30_000 + (300 * audience) + ComedyBonus(audience);

        private static int ComedyBonus(int audience) =>
            audience > 20
                ? 10_000 + 500 * (audience - 20)
                : 0;
    }
}