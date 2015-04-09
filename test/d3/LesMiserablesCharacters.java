package d3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * simple class that has static references to certain Les-Mis characters
 *
 * @author Lawrence Thatcher
 */
public class LesMiserablesCharacters
{
    public static final String JEAN_VALJEAN = "Valjean";

    public static final String JONDRETTE = "Jondrette";
    public static final String JONDRETTE_NEIGHBOR = "Mme.Burgon";

    public static final String MYRIEL = "Myriel";
    public static final String GEBORAND = "Geborand";
    public static final String CHAMPTERCIER = "Champtercier";
    public static final String NAPOLEON = "Napoleon";
    public static final String COUNT = "Count";
    public static final String COUNTESS = "CountessdeLo";
    public static final String OLD_MAN = "OldMan";
    public static final String CRAVETTE = "Cravatte";
    public static final String MAGLOIRE = "Mme.Magloire";
    public static final String BAPTISTINE = "Mlle.Baptistine";

    public static Collection<String> MyrielNeighbors()
    {
        List<String> result = new ArrayList<>();
        result.add(GEBORAND);
        result.add(NAPOLEON);
        result.add(CHAMPTERCIER);
        result.add(COUNT);
        result.add(COUNTESS);
        result.add(OLD_MAN);
        result.add(CRAVETTE);
        result.add(MAGLOIRE);
        result.add(BAPTISTINE);
        result.add(JEAN_VALJEAN);
        return result;
    }
}
