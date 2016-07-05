(ns triangle)

(defn logic? [a b c]
  (and (< c (+ a b))
       (< b (+ a c))
       (< a (+ c b))))

(defn type [a b c]
  (cond (not (logic? a b c)) :illogical
        (= a b c) :equilateral
        (or (= a b) (= b c) (= a c)) :isosceles
        :else :scalene))
