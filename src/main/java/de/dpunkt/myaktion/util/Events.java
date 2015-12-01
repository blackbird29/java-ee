package de.dpunkt.myaktion.util;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Created by blackbird on 12/1/15.
 */
public class Events {
    @Qualifier
    @Target({ FIELD, PARAMETER})
    @Retention(RUNTIME)
    public @interface Added{}

    @Qualifier
    @Target({ FIELD, PARAMETER})
    @Retention(RUNTIME)
    public @interface Deleted{}
}
