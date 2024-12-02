import React, { useState } from 'react';
import { Text, TextInput, View, StyleSheet } from 'react-native';

const PizzaTranslator = () => {
  const [text, setText] = useState('');

  // Função chamada quando o texto é alterado
  const handleChangeText = (newText) => {
    setText(newText);
  };

  // Função chamada ao enviar o texto
  const handleSubmitEditing = () => {
    console.log('Texto enviado:', text);
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        placeholder="Type here to translate!"
        onChangeText={handleChangeText}
        onSubmitEditing={handleSubmitEditing}
        defaultValue={text}
      />
      <Text style={styles.output}>
        {text
          .split(' ')
          .map((word) => word && '🍕')
          .join(' ')}
      </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 10,
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  input: {
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    width: '80%',
    paddingHorizontal: 8,
    marginBottom: 10,
  },
  output: {
    padding: 10,
    fontSize: 42,
    textAlign: 'center',
  },
});

export default PizzaTranslator;
