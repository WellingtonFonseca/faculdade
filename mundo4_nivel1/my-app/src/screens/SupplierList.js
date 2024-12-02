import React, { useContext, useEffect } from 'react';
import { View, Text, Button, FlatList, Image, StyleSheet, ActivityIndicator } from 'react-native';
import { useRouter } from 'expo-router';
import { SupplierContext } from '../context/SupplierContext';

const SupplierList = () => {
  const router = useRouter();
  const { suppliers, isLoading } = useContext(SupplierContext);

  // Força a atualização da lista após voltar do cadastro
  useEffect(() => {
    console.log('Fornecedores na lista:', suppliers); // Verifique se a imagem está incluída
    console.log('Tela SupplierList carregada ou atualizada');
  }, [suppliers]);

  if (isLoading) {
    return (
      <View style={styles.loadingContainer}>
        <ActivityIndicator size="large" color="blue" />
        <Text>Carregando fornecedores...</Text>
      </View>
    );
  }

  return (
    <View style={styles.container}>
      {suppliers.length === 0 ? (
        <Text style={styles.emptyText}>Nenhum fornecedor cadastrado.</Text>
      ) : (
        <FlatList
          data={suppliers}
          keyExtractor={(item) => item.id}
          renderItem={({ item }) => (
            <View style={styles.card}>
              {item.image ? (
                <Image source={{ uri: item.image }} style={styles.image} />
              ) : (
                <View style={styles.placeholder} />
              )}
              <Text style={styles.text}>Id: {item.id}</Text>
              <Text style={styles.text}>Nome: {item.name}</Text>
              <Text style={styles.text}>Endereço: {item.address}</Text>
              <Text style={styles.text}>Contato: {item.contact}</Text>
              <Text style={styles.text}>Categoria: {item.category}</Text>
              <Button style={styles.buttonEdit} title="Editar" onPress={() => router.push(`/edit/${item.id}`)} />
            </View>
          )}
        />
      )}
      <Button title="Cadastrar Fornecedor" onPress={() => router.push('/cadastro')} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20 },
  loadingContainer: { flex: 1, justifyContent: 'center', alignItems: 'center' },
  card: { padding: 10, marginBottom: 10, borderWidth: 1, borderColor: 'gray', borderRadius: 5 },
  image: { width: 50, height: 50 },
  placeholder: { width: 50, height: 50, backgroundColor: 'gray' },
  text: { marginTop: 5, fontSize: 16 },
  emptyText: { fontSize: 18, textAlign: 'center', marginTop: 20, color: 'gray' },
  buttonEdit: {backgroundColor: 'red'},
});

export default SupplierList;
