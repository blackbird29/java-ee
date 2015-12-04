package de.dpunkt.myaktion.util;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by blackbird on 12/4/15.
 */
public class Log {

    @Qualifier
    @Target({ FIELD, METHOD})
    @Retention(RUNTIME)
    public @interface FachLog{}

    @Qualifier
    @Target({ FIELD, METHOD})
    @Retention(RUNTIME)
    public @interface TecLog{}
}
