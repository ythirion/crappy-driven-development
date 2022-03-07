using System;

namespace TheatricalPlayersRefactoringKata
{
    internal static class CreditsCalculator
    {
        public static int CalculateCreditsFor(PlayType performanceType, int audience)
            => Math.Max(audience - 30, 0) +
               (performanceType == PlayType.Comedy ? (int) Math.Floor((decimal) audience / 5) : 0);
    }
}