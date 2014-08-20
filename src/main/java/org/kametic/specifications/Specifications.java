/**
 * Copyright (C) 2013 Kametic <epo.jemba@kametic.com>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * or any later version
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kametic.specifications;

public class Specifications {

    /**
     * 
     * @param <T>
     * @param lhs
     * @param rhs
     * @return
     */
    public static <T> Specification<T> and(Specification<T> lhs, Specification<? super T> rhs) {
        return new AndSpecification<T>(lhs, rhs);
    }

    /**
     * 
     * @param <T>
     * @param lhs
     * @param rhs
     * @return
     */
    public static <T> Specification<T> or(Specification<T> lhs, Specification<? super T> rhs) {
        return new OrSpecification<T>(lhs, rhs);
    }

    /**
     * 
     * @param <T>
     * @param proposition
     * @return
     */
    public static <T> Specification<T> not(Specification<T> proposition) {
        return new NotSpecification<T>(proposition);
    }

    /**
     * Construct a new equals specification.
     * @param <T> type of the candidates being matched
     * @param value the value that our property should be equal to
     * @return new equals specification
     */
    public static <T> Specification<T> equalTo(Object value) {
        return new EqualToSpecification<T>(value);
    }

    /**
     * 
     * @param <T>
     * @param value
     * @return
     */
    public static <T extends Comparable<T>> Specification<T> greaterThan(T value) {
        return new GreaterThanSpecification<T>(value);
    }

    /**
     * 
     * @param <T>
     * @param value
     * @return
     */
    public static <T extends Comparable<T>> Specification<T> greaterOrEqualTo(T value) {
        return new OrSpecification<T>(equalTo(value), greaterThan(value));
    }

    /**
     * 
     * @param <T>
     * @param value
     * @return
     */
    public static <T extends Comparable<T>> Specification<T> lessThan(T value) {
        return new LessThanSpecification<T>(value);
    }

    /**
     * 
     * @param <T>
     * @param value
     * @return
     */
    public static <T extends Comparable<T>> Specification<T> lessOrEqualTo(T value) {
        return new OrSpecification<T>(equalTo(value), lessThan(value));
    }

//    /**
//     * 
//     * @param <T> type of bean that contains our property
//     * @param <P> type of property being checked
//     * @param propertyName name of the property being checked, cannot be blank (<b>required</b>)
//     * @param delegate delegate specification, used to check our property value (<b>required</b>)
//     * @return new property specification, used to check a specific bean property
//     */
//    public static <T, V> Specification<T> property(String propertyName, Specification<V> delegate) {
//        return new PropertySpecification<T, V>(propertyName, delegate);
//    }
//
//    public static <T> Specification<Iterable<? extends T>> anyElement(Specification<T> delegate) {
//        return new AnyElementSpecification<T>(delegate);
//    }
//
//    public static <T> Specification<Iterable<? extends T>> eachElement(Specification<T> delegate) {
//        return new EachElementSpecification<T>(delegate);
//    }

}