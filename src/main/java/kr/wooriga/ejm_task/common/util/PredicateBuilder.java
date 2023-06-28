package kr.wooriga.ejm_task.common.util;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PredicateBuilder {

    private final List<Predicate> predicateBuilders = new ArrayList<>();

    public static PredicateBuilder builder() {
        return new PredicateBuilder();
    }

    public Predicate build() {
        return ExpressionUtils.allOf(predicateBuilders);
    }

    public PredicateBuilder eqString(StringPath column, String value) {

        if (StringUtils.hasText(value)) {
            predicateBuilders.add(column.eq(value));
        }

        return this;
    }

    public PredicateBuilder containsString(StringPath column, String value) {

        if (StringUtils.hasText(value)) {
            predicateBuilders.add(column.contains(value));
        }

        return this;
    }

}
