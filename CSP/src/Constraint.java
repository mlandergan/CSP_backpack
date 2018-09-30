public abstract class Constraint {
	public abstract boolean isValid(State currentState); 
    public abstract boolean isSatisfiable(State currentState);
}
