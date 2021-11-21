import Vue from "vue";
import Vuex from "vuex";
import * as customer from "@/store/modules/customer.js";
import * as search from "@/store/modules/search.js";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    customer,
    search,
  },
  state: {},
  mutations: {},
  actions: {},
});
