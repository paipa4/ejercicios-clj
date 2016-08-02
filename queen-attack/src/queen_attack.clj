(ns queen-attack)

(defn get-square [pos hsh]
  (cond
    (= (hsh :w) pos) "W"
    (= (hsh :b) pos) "B"
    :else "_"))

(defn get-row [row-number hsh]
  (map #(get-square [row-number %] hsh) (range 0 8)))

(defn raw-board [hsh]
  (map #(get-row % hsh) (range 0 8)))

(defn board-string [hsh]
  (str
    (clojure.string/join "\n" (map #(clojure.string/join " " %) (raw-board hsh)))
    "\n"))

(defn lineal-attack? [hsh]
  (or (= (first (hsh :w))
         (first (hsh :b)))
      (= (last (hsh :w))
         (last (hsh :b)))))

(defn diagonal-attack? [hsh]
  (or (= (- (first (hsh :w))
            (last (hsh :w)))
         (- (first (hsh :b))
            (last (hsh :b))))))

(defn can-attack [hsh]
  (or (lineal-attack? hsh)
      (diagonal-attack? hsh)))
