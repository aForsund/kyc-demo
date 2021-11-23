import axios from "axios";

const BASE_URL = "";
//const BASE_URL = "https://stacc-code-challenge-2021.azurewebsites.net";
//const BASE_URL = "http://localhost:8080";

const apiClient = axios.create({
  baseURL: BASE_URL,
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {


  getPerson(name) {
    console.log("searching for " + name);
    return apiClient.get("/api/pep?name=" + name);
  },

  getRoles(data) {
    console.log("searching for " + data);
    return apiClient.get("/api/company/" + data);
  },
};
