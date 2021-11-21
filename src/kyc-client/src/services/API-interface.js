import axios from "axios";

//const BASE_URL = "";
const BASE_URL = "https://stacc-code-challenge-2021.azurewebsites.net";

const apiClient = axios.create({
  baseURL: BASE_URL,
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {
  getUsers() {
    return apiClient.get("/api/user");
  },

  getPerson(name) {
    return apiClient.get("/api/user/" + name);
  },

  getCompany(data) {
    return apiClient.get("/api/company/" + data);
  },

  registerUser(data) {
    return apiClient.post("/api/auth/register", {
      username: data.name,
      email: data.email,
      password: data.password,
    });
  },

  search(data) {
    return apiClient.get("/api/user/search/" + data);
  },

  getRoles(data) {
    console.log("searching for " + data);
    return apiClient.get("/api/roller?orgNr=988971375");
  },
};
