import axios from "axios";

const Api = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 20000,
    headers: {'Content-Type': 'application/json'}
  });

export default Api;