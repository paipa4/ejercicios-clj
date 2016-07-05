(ns space-age)

(defn on-earth [seconds]
  (/ seconds 31557600.0))

(defn on-uranus [seconds]
  (/ (on-earth seconds) 84.01))

(defn on-mercury [seconds]
  (/ (on-earth seconds) 0.24085))

(defn on-venus [seconds]
  (/ (on-earth seconds) 0.6152))

(defn on-mars [seconds]
  (/  (on-earth seconds) 1.8809))

(defn on-jupiter [seconds]
  (/ (on-earth seconds) 11.86))

(defn on-saturn [seconds]
  (/ (on-earth seconds) 29.447498))

(defn on-neptune [seconds]
  (/ (on-earth seconds) 164.79132))
