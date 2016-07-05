(ns grains)

(defn square [n]
    (if (= n 1)
      1
      (biginteger (* (square (dec n)) 2))))


(defn total []
     (+ (* (square (dec 64)) 2) (dec (square 64))))



