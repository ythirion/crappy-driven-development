using System.Collections.Generic;

namespace TheatricalPlayersRefactoringKata
{
    public record Invoice(string Customer, IReadOnlyList<Performance> Performances);
}
