package com.davidlabs;

import java.util.function.Predicate;

interface ICheck<T,U>{
    boolean check(T t, Predicate<U> p); 
}
