import API_Interface from "../../services/API-interface";

export const namespaced = true;

export const state = {
  searchResults: null,
  searchString: null,
  infoText: null,
};

export const mutations = {
  UPDATE_SEARCH_RESULTS(state, searchResults) {
    state.searchResults = searchResults;
  },
  CLEAR_SEARCH_RESULTS(state) {
    state.searchResults = null;
  },
  UPDATE_SEARCH_RESULT_INFO_TEXT(state, text) {
    state.infoText = text;
  },
  CLEAR_SEARCH_RESULT_INFO_TEXT(state) {
    state.infoText = null;
  },
};

export const actions = {
  search({ commit }, data) {

    
    (isNaN(data) ? API_Interface.getPerson(data) : API_Interface.getRoles(data))
        .then((response) => {
          console.log(response.data);
          commit("UPDATE_SEARCH_RESULTS", response.data);
          commit(
            "UPDATE_SEARCH_RESULT_INFO_TEXT",
            "Displaying result" + " add logic operator here " + "for " + data
          );
        })
        .catch((err) => {
          console.log(err);
          commit("CLEAR_SEARCH_RESULTS");
          commit("UPDATE_SEARCH_RESULT_INFO_TEXT", err);
        });
    
    
  },
    
};

export const getters = {
  searchResults(state) {
    return state.searchResults;
  },
  infoText(state) {
    return state.infoText;
  },
};
