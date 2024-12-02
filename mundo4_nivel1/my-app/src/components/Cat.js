import React from 'react';
import { Text, TextInput, View, StyleSheet } from 'react-native';

const Cat = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Hello, I am...</Text>
      <TextInput
        style={styles.input}
        defaultValue="Name me!"
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 10,
    alignItems: 'center',
  },
  text: {
    fontSize: 18,
    marginBottom: 10,
  },
  input: {
    height: 40,
    width: '80%',
    borderColor: 'gray',
    borderWidth: 1,
    paddingHorizontal: 10,
  },
});

export default Cat;
