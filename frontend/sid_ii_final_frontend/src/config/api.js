import axios from 'axios'

const backend = axios.create({
    baseURL: 'http://localhost:8080', 
  });

export const login = async (id) => {
    try {
      const response = await backend.get(`/api/clientes/${id}`);
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
    const response = await backend.get(`/api/detalles-cliente/${id}`);
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
