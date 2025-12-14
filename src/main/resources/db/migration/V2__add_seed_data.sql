INSERT INTO category (id, name, definition, low_val, high_val) VALUES
                                                                   (1, 'Untergewicht', 'Als Untergewicht wird ein Körpergewicht bei einem Body-Mass-Index (BMI) von unter 18.5 kg/m<sup>2</sup> bezeichnet. Bei Kindern ist eine Bewertung anhand des BMI nur bedingt geeignet, hier müssen altersabhängige Referenzwerte oder das Längensollgewicht herangezogen werden. Ein Längensollgewicht unter 90 % ist für untergewichtige Kinder kennzeichnend. Vor allem Kinder in Entwicklungsländern zeigen Untergewicht. Ursachen für Untergewicht sind Unterernährung, Magersucht (Anorexia nervosa) und schwerwiegende oder chronische Krankheiten. Bei deutlicher Abmagerung spricht man von Inanition, bei schwerwiegenden Krankheitsbildern von Kachexie.', NULL, 18.5),
                                                                   (2, 'Normalgewicht', 'Es gibt keinen medizinischen Konsens, was das als Normalgewicht zu bezeichnende "wünschenswerte" oder "natürliche" Körpergewicht eines Menschen sein sollte. Es ist sogar strittig, ob es einen solchen festzulegenden Wert überhaupt gibt. Insofern existieren verschiedene Bemessungsformeln zur Ermittlung des Normal- bzw. Ideal- und Unter- bzw. Übergewichts, die im Ergebnis ähnliche Werte ergeben. Trotz dieser Diskussion um den richtigen Wert eines Normal- oder Idealgewichtes gibt es klare Vorstellungen, außerhalb welcher Gewichtsbandbreite eine Person als (krankhaft) unter- oder übergewichtig zu beurteilen ist.', 18.5, 25.0),
                                                                   (3, 'Übergewicht', 'Als Übergewicht wird ein hohes Körpergewicht (bzw. eine große Körpermasse) im Verhältnis zur Körpergrösse bezeichnet. Im engeren Sinne ist damit nur die sogenannte Präadipositas gemeint, im Gegensatz zum schweren Übergewicht, der Fettleibigkeit oder Adipositas. Das medizinische Fachgebiet, das sich mit dem Übergewicht beschäftigt, ist die Bariatrie.', 25.0, 30.0),
                                                                   (4, 'Fettleibigkeit', 'Fettleibigkeit (Adipositas, von lateinisch <em>adeps</em> "Fett"), Fettsucht oder Obesitas (selten Obesität) ist eine Ernährungs- und Stoffwechselkrankheit mit starkem Übergewicht und positiver Energiebilanz, die durch eine über das normale Maß hinausgehende Vermehrung des Körperfettes mit häufig krankhaften Auswirkungen gekennzeichnet ist. Nach der WHO-Definition liegt eine Adipositas bei Menschen ab einem Körpermasseindex (BMI) von 30 kg/m<sup>2</sup> vor. Dabei wird in drei über den BMI voneinander abgegrenzte Schweregrade unterschieden. Indikatoren für den Anteil von Körperfett und dessen Verteilung sind der Bauchumfang und das Taille-Hüft-Verhältnis.', 30.0, NULL);

SELECT setval(pg_get_serial_sequence('category', 'id'), (SELECT MAX(id) FROM category));

INSERT INTO sub_category (category_id, name, low_val, high_val) VALUES
                                                                    (1, 'stark', NULL, 16.0),
                                                                    (1, 'mässig', 16.0, 17.0),
                                                                    (1, 'leicht', 17.0, 18.5),
                                                                    (4, 'Grad I', 30.0, 35.0),
                                                                    (4, 'Grad II', 35.0, 40.0),
                                                                    (4, 'Grad III', 40.0, NULL);

INSERT INTO statistic (iso_code, country, rank_val, both_gender, male, female) VALUES
                                                                                   ('AT', 'Austria', 119, 25.4, 26.5, 24.4),
                                                                                   ('BE', 'Belgium', 114, 25.5, 26.2, 24.7),
                                                                                   ('CH', 'Switzerland', 125, 25.3, 26.7, 23.8),
                                                                                   ('CZ', 'Czechia', 55, 26.9, 27.8, 26.0),
                                                                                   ('DE', 'Germany', 79, 26.3, 27.0, 25.6),
                                                                                   ('ES', 'Spain', 63, 26.7, 27.4, 26.0),
                                                                                   ('FR', 'France', 124, 25.3, 26.1, 24.6),
                                                                                   ('GB', 'United Kingdom', 40, 27.3, 27.5, 27.1),
                                                                                   ('HK', 'Hong Kong', NULL, NULL, NULL, NULL),
                                                                                   ('IT', 'Italy', 94, 26.0, 26.8, 25.2),
                                                                                   ('LI', 'Liechtenstein', 192, NULL, NULL, NULL),
                                                                                   ('SE', 'Sweden', 106, 25.8, 26.7, 24.9),
                                                                                   ('TR', 'Turkey', 31, 27.8, 27.1, 28.5),
                                                                                   ('TW', 'Taiwan', 195, NULL, NULL, NULL),
                                                                                   ('US', 'United States', 20, 28.5, 28.5, 28.5),
                                                                                   ('VA', 'Vatican City', 196, NULL, NULL, NULL);
