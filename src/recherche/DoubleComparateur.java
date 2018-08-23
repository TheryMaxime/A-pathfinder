package recherche;

import java.util.Comparator;

public class DoubleComparateur implements Comparator<CaseEnAttenteDeTraitement> {

	@Override
	public int compare(CaseEnAttenteDeTraitement o1, CaseEnAttenteDeTraitement o2) {
		// TODO Auto-generated method stub
		if (o1.getLongeurDepuisLaPosition()<o2.getLongeurDepuisLaPosition())
			return -1;
		if (o1.getLongeurDepuisLaPosition()>o2.getLongeurDepuisLaPosition())
			return 1;
		return 0;
	}

}
