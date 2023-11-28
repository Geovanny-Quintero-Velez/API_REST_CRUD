import axios from 'axios'

const backend = axios.create({
    baseURL: 'http://localhost:8080', 
  });

export const login = async (id) => {
    try {
      const numero = parseInt(id, 10);
      const response = await backend.get(`/api/clientes/${numero}`);
      console.log(response.data)

      const userExists = response.data && response.data.id;

      if (userExists) {
        return response.data;
      } else {
        throw new Error('Usuario no encontrado');
      }
    } catch (error) {
      throw error
    }
};

export const addDetail = async (userDetail) => {
  try {
    console.log(userDetail);
    const response = await backend.post('/api/detalles-cliente', userDetail);
    return response.data;
  }catch(error){
    throw error
  }
}

export const updateDetail = async (id,userDetail) => {
  try {
    const response = await backend.put(`/api/detalles-cliente/${id}`,userDetail);
    return response.data;
  }catch(error){
    throw error
  }
}

export const getDetail = async (id) => {
  try {
    console.log("id en el metodo de la api: " + id);
    const cadena = id + "";
    const response = await backend.get(`/api/detalles-cliente/${cadena}`);
    return response.data;
  }catch(error){
    throw error
  }
}

export const addOrderDetail = async (orderDetail) => {
  try {
    const response = await backend.post('/api/ordenes-detalle', orderDetail);
    return response.data;
  }catch(error){
    throw error
  }
}

export const addOrder = async (order) => {
  try {
    const response = await backend.post('/api/ordenes', order);
    return response.data;
  }catch(error){
    throw error
  }
}

export const getProducts = async () => {
  try {
    const response = await backend.get('/api/products');
    return response.data;
  }catch(error){
    throw error
  }
}

export const getCategories = async () => {
  try {
    const response = await backend.get('/api/categories');
    return response.data;
  }catch(error){
    throw error
  }
}

export const getOrdersByClient = async (codigoCliente) => {
  try {
    const response = await backend.get(`/api/ordenes/${codigoCliente}`);
    return response.data;
  }catch(error){
    throw error
  }
}

export const getOrder = async (id) => {
  try {
    const response = await backend.get(`/api/ordenes/${id}`);
    return response.data;
  }catch(error){
    throw error
  }
}

export const getOrderDetails = async (id) => {
  try {
    const response = await backend.get(`ordenes-detalle/${id}`);
    return response.data;
  }catch(error){
    throw error
  }
}