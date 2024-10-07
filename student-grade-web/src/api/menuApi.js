import request from "@/utils/request.js";

export const  loadMenuServer= async ()=>{
    return await request.get("/menuList");
}