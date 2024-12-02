import React, { useState, useContext, useEffect } from 'react';
import { View, Text, TextInput, Button, StyleSheet } from 'react-native';
import { useRouter, useLocalSearchParams } from 'expo-router';
import * as ImagePicker from 'expo-image-picker';
import { SupplierContext } from '../context/SupplierContext';

const EditForm = () => {
  const { suppliers, updateSupplier } = useContext(SupplierContext);
  const router = useRouter();
  const { id } = useLocalSearchParams();

  const [name, setName] = useState('');
  const [address, setAddress] = useState('');
  const [contact, setContact] = useState('');
  const [category, setCategory] = useState('');
  const [image, setImage] = useState(null);
  const [message, setMessage] = useState('');
  const [messageType, setMessageType] = useState(''); // 'error' ou 'success'

  useEffect(() => {
    const supplier = suppliers.find((supplier) => supplier.id === id);
    
    if (supplier) {
      setName(supplier.name);
      setAddress(supplier.address);
      setContact(supplier.contact);
      setCategory(supplier.category);
      setImage(supplier.image);
    }
  }, [id, suppliers]);

  const pickImage = async () => {
    let result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      quality: 0.3, // Reduz a qualidade para economizar espaço
    });

    console.log('Resultado do ImagePicker:', result); // Verifique a estrutura do retorno
  
    if (!result.canceled && result.assets && result.assets.length > 0) {
      const selectedImage = result.assets[0].uri;
      console.log('Imagem selecionada:', selectedImage); // Certifique-se de que o URI é válido
      setImage(selectedImage);
    } else {
      console.log('Nenhuma imagem selecionada ou operação cancelada.');
    }
    
  };

  const handleSave = () => {
    if (!name || !address || !contact || !category) {
      setMessage('Todos os campos são obrigatórios!');
      setMessageType('error');
      return;
    }

    const updatedSupplier = { id, name, address, contact, category, image };
    console.log('Fornecedor a ser salvo:', updatedSupplier); // Verifique se a imagem está incluída
    updateSupplier(updatedSupplier); // Atualiza o fornecedor na lista global
    setMessage('Fornecedor cadastrado com sucesso!');
    setMessageType('success');

    setTimeout(() => {
      router.push('/'); // Redireciona para a tela inicial
    }, 2000);
  };

  return (
    <View style={styles.container}>
      {message ? (
        <Text style={[styles.message, messageType === 'error' ? styles.error : styles.success]}>
          {message}
        </Text>
      ) : null}
      <Text style={styles.label}>id: {id}</Text>
      <Text style={styles.label}>Nome</Text>
      <TextInput style={styles.input} value={name} onChangeText={setName} placeholder="Nome do fornecedor" />
      <Text style={styles.label}>Endereço</Text>
      <TextInput style={styles.input} value={address} onChangeText={setAddress} placeholder="Endereço" />
      <Text style={styles.label}>Contato</Text>
      <TextInput style={styles.input} value={contact} onChangeText={setContact} placeholder="Contato" />
      <Text style={styles.label}>Categoria</Text>
      <TextInput style={styles.input} value={category} onChangeText={setCategory} placeholder="Categoria" />
      <Button title="Escolher Imagem" onPress={pickImage} />
      {image && <Text style={styles.imageText}>Imagem selecionada!</Text>}
      <Button title="Salvar" onPress={handleSave} />
      <Button title="Voltar" onPress={() => router.push('/')} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: { padding: 20 },
  label: { fontSize: 16, marginTop: 10 },
  input: { borderWidth: 1, borderColor: 'gray', borderRadius: 5, padding: 10, marginTop: 5 },
  imageText: { marginTop: 10, color: 'green' },
  error: { color: 'red' },
  success: { color: 'green' },
});

export default EditForm;
