import 'package:flutter/material.dart';

class PackageList extends StatelessWidget {
  // Adiciona o parâmetro filteredPackages na classe
  final List<Map<String, String>> filteredPackages;

  // Construtor atualizado para aceitar o parâmetro filteredPackages
  const PackageList({super.key, required this.filteredPackages});

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      itemCount: filteredPackages.length,
      itemBuilder: (context, index) {
        final package = filteredPackages[index];
        return ListTile(
          leading: const Icon(Icons.card_travel),
          title: Text(package['title']!),
          subtitle: Text('R\$ ${package['price']}'),
          trailing: const Icon(Icons.arrow_forward_ios),
          onTap: () {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(content: Text('Abrindo ${package['title']}')),
            );
          },
        );
      },
    );
  }
}
