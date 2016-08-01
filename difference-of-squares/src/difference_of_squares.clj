(ns difference-of-squares)

(defn square [n] (* n n))

(defn square-of-sums [n]
  (square (reduce + (range 1 (inc n)))))

(defn sum-of-squares [n]
  (reduce + (map #(square %) (range 1 (inc n)))))

(defn difference [n]
  (- (square-of-sums n) (sum-of-squares n)))
