package org.hamcrest.collection;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

import java.util.Collection;

/**
 * Matches if collection size satisfies a nested matcher.
 */
public class IsCollectionWithSize extends FeatureMatcher<Collection<?>, Integer> {
    public IsCollectionWithSize(Matcher<? super Integer> sizeMatcher) {
      super(sizeMatcher, "a collection with size", "collection size");
    }

    @Override
    protected Integer featureValueOf(Collection<?> actual) {
      return actual.size();
    }

    /**
     * Creates a matcher for {@link java.util.Collection}s that matches when the <code>size()</code> method returns
     * a value that satisfies the specified matcher.
     *
     * For example:
     * <pre>assertThat(Arrays.asList("foo", "bar"), hasSize(equalTo(2)))</pre>
     * 
     * @param sizeMatcher
     *     a matcher for the size of an examined {@link java.util.Collection}
     */
    public static Matcher<Collection<?>> hasSize(Matcher<? super Integer> sizeMatcher) {
        return new IsCollectionWithSize(sizeMatcher);
    }

    /**
     * Creates a matcher for {@link java.util.Collection}s that matches when the <code>size()</code> method returns
     * a value equal to the specified <code>size</code>.
     *
     * For example:
     * <pre>assertThat(Arrays.asList("foo", "bar"), hasSize(2))</pre>
     * 
     * @param size
     *     the expected size of an examined {@link java.util.Collection}
     */
    public static Matcher<Collection<?>> hasSize(int size) {
       return hasSize(IsEqual.equalTo(size));
    }

}
