package recherche;

import carte.Case;

public class CaseEnAttenteDeTraitement  {

	/**
	 * 
	 */
	private double longeurDepuisLaPosition;
	private CaseEnAttenteDeTraitement casePrecedente;
	private Case caseCorrespondante;

	public CaseEnAttenteDeTraitement(Case caseCorrespondante, double longeurDepuisLaPosition,
			CaseEnAttenteDeTraitement casePrecedente) {
		this.caseCorrespondante = caseCorrespondante;
		this.longeurDepuisLaPosition = longeurDepuisLaPosition;
		this.casePrecedente = casePrecedente;
	}

	public CaseEnAttenteDeTraitement(Case caseCorrespondante, double longeurDepuisLaPosition) {
		this.caseCorrespondante = caseCorrespondante;
		this.longeurDepuisLaPosition = longeurDepuisLaPosition;
	}

	
	public void setLongeurDepuisLaPosition(double longeurDepuisLaPosition) {
		this.longeurDepuisLaPosition = longeurDepuisLaPosition;
	}

	public double getLongeurDepuisLaPosition() {
		return this.longeurDepuisLaPosition;
	}
	
	public void setCasePrecedente(CaseEnAttenteDeTraitement casePrecedente) {
		this.casePrecedente = casePrecedente;
	}

	public CaseEnAttenteDeTraitement getCasePrecedente() {
		return this.casePrecedente;
	}

	public Case getCase() {
		return this.caseCorrespondante;
	}

}
