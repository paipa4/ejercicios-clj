(ns leap)

(defn leap-year? [number]
  (if (zero? (mod number 100))
    (zero? (mod number 400))
    (zero? (mod number 4))))


(leap-year? 1977)
