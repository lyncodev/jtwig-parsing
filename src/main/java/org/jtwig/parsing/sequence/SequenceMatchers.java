package org.jtwig.parsing.sequence;

import org.jtwig.parsing.character.CharacterMatcher;
import org.jtwig.parsing.character.WhiteSpaceCharacterMatcher;
import org.jtwig.parsing.transform.Transformation;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jtwig.parsing.character.CharacterMatchers.whiteSpace;

public class SequenceMatchers {
    public static CharacterSequenceMatcher match (CharacterMatcher characterMatcher) {
        return new CharacterSequenceMatcher(characterMatcher);
    }

    public static StringSequenceMatcher string (String text) {
        return new StringSequenceMatcher(text);
    }

    public static ConsecutiveSequenceMatcher sequence (SequenceMatcher... others) {
        return new ConsecutiveSequenceMatcher(asList(others));
    }

    public static DisjunctiveSequenceMatcher or (SequenceMatcher... others) {
        return new DisjunctiveSequenceMatcher(asList(others));
    }
    public static DisjunctiveSequenceMatcher or (List<SequenceMatcher> others) {
        return new DisjunctiveSequenceMatcher(others);
    }

    public static MandatorySequenceMatcher mandatory(SequenceMatcher sequenceMatcher) {
        return new MandatorySequenceMatcher(sequenceMatcher);
    }

    public static ZeroOrMoreSequenceMatcher zeroOrMore(SequenceMatcher sequenceMatcher) {
        return new ZeroOrMoreSequenceMatcher(sequenceMatcher);
    }

    public static TestSequenceMatcher test (SequenceMatcher sequenceMatcher) {
        return new TestSequenceMatcher(sequenceMatcher);
    }

    public static UntilSequenceMatcher until (SequenceMatcher sequenceMatcher) {
        return new UntilSequenceMatcher(sequenceMatcher);
    }

    public static FirstOfSequenceMatcher firstOf (SequenceMatcher... sequenceMatchers) {
        return new FirstOfSequenceMatcher(asList(sequenceMatchers));
    }

    public static FirstOfSequenceMatcher firstOf (List<SequenceMatcher> sequenceMatchers) {
        return new FirstOfSequenceMatcher(sequenceMatchers);
    }

    public static NotSequenceMatcher not (SequenceMatcher sequenceMatcher) {
        return new NotSequenceMatcher(sequenceMatcher);
    }

    public static <T> TransformSequenceMatcher<T> transform (SequenceMatcher sequenceMatcher, Transformation<T> transform) {
        return new TransformSequenceMatcher<>(sequenceMatcher, transform);
    }

    public static FlattenSequenceMatcher flatten (SequenceMatcher sequenceMatcher) {
        return new FlattenSequenceMatcher(sequenceMatcher);
    }

    public static SequenceMatcher whitespaces () {
        return zeroOrMore(match(whiteSpace()));
    }

    public static SkipWhiteSpacesSequenceMatcher skipWhitespaces (SequenceMatcher sequenceMatcher) {
        return new SkipWhiteSpacesSequenceMatcher(new WhiteSpaceCharacterMatcher(), sequenceMatcher);
    }

    public static OptionalSequenceMatcher optional (SequenceMatcher matcher) {
        return new OptionalSequenceMatcher(matcher);
    }

    public static OneOrMoreSequenceMatcher oneOrMore(SequenceMatcher delegate) {
        return new OneOrMoreSequenceMatcher(delegate);
    }

    public static MergeSequenceMatcher merge (SequenceMatcher... list) {
        return new MergeSequenceMatcher(asList(list));
    }

    public static MergeSequenceMatcher merge (List<SequenceMatcher> list) {
        return new MergeSequenceMatcher(list);
    }
}
