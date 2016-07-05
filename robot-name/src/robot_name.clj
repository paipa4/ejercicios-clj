(ns robot-name)


  (def counter
    (atom 0))

  (defn create-name []
    (str "AA" (format "%03d" (swap! counter inc))))

  (defn robot []
    (atom {:name (create-name)}))


  (defn reset-name [-robot]
    (let [name (create-name)]
      (swap! -robot assoc :name name)))

  (defn robot-name [-robot]
    (get @-robot :name))

