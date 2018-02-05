package com.gc.navigationinjector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    Class<? extends Operation> Operation();
    Class<? extends BaseViewModel> ViewModel();
    Class<? extends BaseActivity> Activity() default BaseActivity.Default.class;
    Class<? extends BaseFragment> Fragment() default BaseFragment.Default.class;
}
