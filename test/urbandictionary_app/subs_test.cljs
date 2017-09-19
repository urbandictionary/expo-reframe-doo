(ns urbandictionary-app.subs-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [re-frame.registrar :as registrar]
            [re-frame.core :as rf]
            re-frame.db
            [urbandictionary-app.handlers :as handlers]
            [urbandictionary-app.db :as db]
            urbandictionary-app.subs))

(deftest subscribe-greeting-test
         (let [greeting (rf/subscribe [:get-greeting])]
              (rf/dispatch-sync [:set-greeting "hi moms"])
              (is (= "hi moms" @greeting))))
