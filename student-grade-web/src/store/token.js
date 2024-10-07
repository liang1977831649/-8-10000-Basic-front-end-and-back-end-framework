import { ref } from "vue";
import { defineStore } from "pinia";

export const useToken = defineStore("pinia", () => {
  const token = ref("");

  const setToken = (newToken) => {
    token.value = newToken;
  }

  const removeToken = () => {
    token.value = "";
  }

  return { token, setToken, removeToken }
  
},{persist:true});
