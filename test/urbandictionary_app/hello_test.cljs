(ns urbandictionary-app.hello-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [re-frame.registrar :as registrar]
            [re-frame.core :as rf]
            re-frame.db
            [urbandictionary-app.handlers :as handlers]
            [urbandictionary-app.db :as db]))

(deftest my-test
         (is (= 2 2)))

(deftest set-greeting-test
         (rf/dispatch-sync [:initialize-db])
         (is (= db/app-db @re-frame.db/app-db))

         (rf/dispatch-sync [:set-greeting "hi mom"])
         (is (= "hi mom" (:greeting @re-frame.db/app-db))))

