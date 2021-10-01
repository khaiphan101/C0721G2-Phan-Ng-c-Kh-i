package _20_behavioral_design_pattern.practice.observer;

import javax.security.auth.Subject;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
